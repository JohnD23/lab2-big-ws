package translator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import translator.Application;
import translator.domain.TranslatedText;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TranslatorServiceTest {

private	ArrayList<String> LanguagesList = new ArrayList<>();	
private	ArrayList<String> TextList = new ArrayList<>();


    @Autowired
    TranslatorService translatorService;
    @Test
    public void translateTest() throws Exception {
    	
    LanguagesList.add("en");
    LanguagesList.add("es");
    LanguagesList.add("fr");
    LanguagesList.add("de");
    LanguagesList.add("pt");
    LanguagesList.add("it");
    LanguagesList.add("ca");
    LanguagesList.add("ja");
    
    TextList.add("Test of translation service for various languages");
    TextList.add("Prueba de servicio de traducción para varios idiomas");
    TextList.add("Essai de traduction en différentes langues");
    TextList.add("Test von übersetzungs service für diverse Sprachen");
    TextList.add("Teste de serviço de tradução para vários idiomas");
    TextList.add("Test del servizio di traduzione in diverse lingue");
    TextList.add("Prova de servei de traducció per a diversos idiomes");
    TextList.add("試験の翻訳サービスのための様々な言語");
    	
    	for (int i = 1; i < TextList.size(); i++) {
    		TranslatedText translatedText = translatorService.translate(LanguagesList.get(0),
				LanguagesList.get(i), TextList.get(0));
    		assertEquals(TextList.get(i),translatedText.getTranslation());
    	}
        
    }

}