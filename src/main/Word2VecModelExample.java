


import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.plot.BarnesHutTsne;
import org.deeplearning4j.text.sentenceiterator.LineSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.EndingPreProcessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.nd4j.linalg.io.ClassPathResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jna.platform.win32.COM.DispatchVTable.GetIDsOfNamesCallback;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;




public class Word2VecModelExample {
	
	
	private static String getInputFile() {
		System.out.println("Inserte nombre del fichero: ");
		Scanner sc = new Scanner(System.in);
		 return sc.next();
	}
	
	private static String getOutPutFile() {
		String respuesta= "";
		
		Scanner sc = new Scanner(System.in);
		while(!respuesta.equals("Y") && !respuesta.equals("N")) {
			System.out.println("Desea que su fichero tenga nombre unico? (Y/N): ");
			respuesta = sc.next();
		}
		String word="";
		boolean apropiado = false;
			System.out.println("Inserte el nombre del fichero:");
			word = sc.next();
		if (respuesta.equals("Y")) {
			//sumamos la fecha-
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm_ss");  
			LocalDateTime now = LocalDateTime.now();  
			
			String result = word+"_"+dtf.format(now)+".txt";
			return result;
		}
		else {
			return word;
		}
	
	}
	
    private static Logger log = LoggerFactory.getLogger(Word2VecModelExample.class);
    public static void main(String[] args) throws Exception {
        final SentenceIterator iterator = new LineSentenceIterator(new ClassPathResource(getInputFile()).getFile());
        SentenceDataPreProcessor.setPreprocessor(iterator);
        final TokenizerFactory tokenizerFactory = new DefaultTokenizerFactory();
        tokenizerFactory.setTokenPreProcessor(new EndingPreProcessor());

        final Word2Vec model = new Word2Vec.Builder()
                                        .iterate(iterator)
                                        .tokenizerFactory(tokenizerFactory)
                                        .minWordFrequency(5)
                                        .layerSize(100)
                                        .seed(42)
                                        .epochs(10)
                                        .windowSize(5)
                                        .build();
        log.info("Fitting Word2Vec model....");
        model.fit();

        final Collection<String> words = model.wordsNearest("season",5);
        for(final String word: words){
            System.out.println(word+ " ");
        }
        final double cosSimilarity = model.similarity("season","season");
        System.out.println(cosSimilarity);

        BarnesHutTsne tsne = new BarnesHutTsne.Builder()
                .setMaxIter(100)
                .theta(0.5)
                .normalize(false)
                .learningRate(500)
                .useAdaGrad(false)
                .build();


        //save word vectors for tSNE visualization.
        WordVectorSerializer.writeWordVectors(model.lookupTable(),new File("E://Programas_ULL/Pruebas_misticas/"+getOutPutFile()));
        WordVectorSerializer.writeWord2VecModel(model, "E://Programas_ULL/Pruebas_misticas/model.zip");

    }
}
