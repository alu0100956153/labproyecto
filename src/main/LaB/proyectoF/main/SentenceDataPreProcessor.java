package LaB.proyectoF.main;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
/**
 * \brief clase encargada de todo el preprocesamiento del input
 * 
 */
public class SentenceDataPreProcessor{
	/**
	 * \brief preprocesado de 
	 * @param iterator
	 */
		public static void setPreprocessor(SentenceIterator iterator){
	        iterator.setPreProcessor(((String sentence) -> sentence.toLowerCase()));
	    }
	}