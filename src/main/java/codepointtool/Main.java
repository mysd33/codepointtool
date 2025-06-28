package codepointtool;

import java.io.IOException;
import java.util.List;

import codepointtool.formater.JISSyukutaiMapParser;
import codepointtool.model.JISCharacter;

public class Main {
    public static void main(String[] args) throws IOException {
        // パーサーのインスタンスを作成
        JISSyukutaiMapParser parser = new JISSyukutaiMapParser();

        List<JISCharacter> characters = parser.parse(jisCharacter -> {
            // 1面1句の文字のみを対象とするフィルタ
            return "01".equals(jisCharacter.getMen()) && "01".equals(jisCharacter.getKu());
        });
        
        // 結果を出力
        for (JISCharacter character : characters) {
            System.out.println(character);
        }

    }
}
