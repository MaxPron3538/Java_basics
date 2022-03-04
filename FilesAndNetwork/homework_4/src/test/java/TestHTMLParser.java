import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestHTMLParser {

    private StringBuilder stringBuilder = new StringBuilder();

    @BeforeEach
    void setUp(){
        stringBuilder.append("owl_article_280_64f953e3c371524c94fa4ab3a8c3796e.jpg\n" +
                "owl_feature_580_97c7c3dff59019d00c5b8b50bebeaa0b.jpg\n" +
                "owl_article_280_f8968006c460e3250d2e9bd26ac61cfb.jpg\n" +
                "owl_article_280_85826f7a526d08d5fbb3c41a329e531b.jpg\n" +
                "owl_sq_40_aefc70c273bc90e4ea9798df6c1074cc.jpg\n" +
                "owl_sq_40_d58ebd1eb5cbd80a1388fe5178f7dd64.jpg\n" +
                "owl_sq_40_b21bcd00591e15d5a0d00a950445e025.jpg\n" +
                "owl_sq_40_2c686fdb8752a4a0d84936fc5f896cfd.jpg\n" +
                "owl_sq_40_7626c5b688e1d5773e8b5f03bd1ca5fa.jpg\n" +
                "owl_sq_40_0915571951278d857b95f3dcbb9c425c.jpg\n" +
                "owl_sq_40_2e586888af1bdf8c2ead7d339ae57d02.jpg\n" +
                "owl_sq_40_87cb5011e57272f78d97d4a5a03e092f.jpg\n" +
                "owl_article_280_e924bd87ba5f0770a053a3b551de6688.jpg\n" +
                "owl_article_280_def4de0e04532cf212faca44d1b65523.jpg\n" +
                "owl_article_280_92cc75c9e0bf7fc3372838087fa17909.jpg\n" +
                "owl_article_280_d1b43cdf7dd63e5f246813ea8ec3a5f2.jpg\n" +
                "owl_article_280_3c31ed961b8c050adb00c9de1c63865c.jpg\n" +
                "owl_article_280_3581cf9800e7fe7a00f6c216e7bac9fc.jpg\n" +
                "owl_article_280_074838fd01c58ac7bbfec08735d47a43.jpg\n" +
                "owl_article_280_53aedcadaebb0bfd382e7b3ba6418cfe.jpg\n" +
                "owl_article_280_1488ce3cab0ba66154a7e72e32973145.jpg\n" +
                "owl_article_280_cbdac3d766f85653bb68696e497a0b47.jpg\n" +
                "owl_article_280_75a7c3793cd1cf1a69a4fa86e922aecf.jpg\n" +
                "owl_article_280_a4d3b7afb6d13c9f73e5db2f4fa9ce16.jpg\n" +
                "owl_article_280_92f98796634b3a68543aa0c10b6371eb.jpg\n" +
                "owl_article_280_5890cb524ae979e45cf9063c37815a77.jpg\n" +
                "owl_article_280_a28f061583bb49b64c87938f268c06be.jpg\n" +
                "owl_article_280_8b13e9ef8ece6f85927b62cd6218519b.jpg\n" +
                "owl_article_280_7098d052f657a9df640b2a119b269209.jpg\n" +
                "owl_article_280_82223256befb6e64cfe853180068e754.jpg\n" +
                "owl_article_280_9d2220e83c1f000a1c0c7f917390fa9a.jpg\n" +
                "owl_article_280_cf857b4397f0d1b19d60c62f7ad858bb.jpg");
    }

    @Test
    @DisplayName("Получение списка имен jpg файлов")
    void testSumIncome() throws IOException{

       String actualName = HTMLParser.ParseReferenceHtml("https://lenta.ru").get(8);
       String expectedName = Arrays.stream(stringBuilder.toString()
               .split("\n")).filter(s -> s.contains("1d5773e8b5f03bd1ca5fa")).collect(Collectors.joining());
       assertEquals(expectedName,actualName);
    }
}

