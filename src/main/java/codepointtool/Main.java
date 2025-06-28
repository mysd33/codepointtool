package codepointtool;

import java.io.IOException;
import java.util.List;

import codepointtool.formatter.CodePointsClassCodeFormatter;
import codepointtool.model.CodePointsClassModel;
import codepointtool.model.JISCharacter;
import codepointtool.parser.JISSyukutaiMapParser;

public class Main {
    // JIS縮退マップのExcelファイル名
    private static final String JIS_SYKUTAI_MAP_FILEPATH = "input/jissyukutaimap1_0_0.xlsx";
    
    public static void main(String[] args) throws IOException {
        // パーサーのインスタンスを作成
        JISSyukutaiMapParser parser = new JISSyukutaiMapParser(JIS_SYKUTAI_MAP_FILEPATH);
        // フォーマッタのインスタンスを作成
        CodePointsClassCodeFormatter formatter = new CodePointsClassCodeFormatter();

        List<JISCharacter> characters = parser.parse(jisCharacter -> {
            // 1面1句の文字のみを対象とするフィルタ
            return "01".equals(jisCharacter.getMen()) && "01".equals(jisCharacter.getKu());
        });
        
        CodePointsClassModel codePointsClassModel = CodePointsClassModel.builder()
                .packageName("com.example.fw.common.codepoints")
                .className("SampleCodePoints")
                .description("JISの1面1区の文字を表すクラス")
                .characters(characters)
                .build();

        formatter.format(codePointsClassModel);
        
        
        // 結果を出力
        /*
        for (JISCharacter character : characters) {
            System.out.println(character);
        }*/

    }
}
