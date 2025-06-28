package codepointtool.parser;

import codepointtool.model.JISCharacter;

/**
 * 特定の条件に合致するJISCharacterのみを対象とするための
 * フィルタリングするインターフェース
 * 
 */
public interface TargetFilter {
    /**
     * JISCharacterがこのフィルタの対象かどうかを判定する
     * @param jisCharacter 対象のJISCharacter
     */
   boolean isTarget(JISCharacter jisCharacter);

}
