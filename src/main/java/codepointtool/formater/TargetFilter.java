package codepointtool.formater;

import codepointtool.model.JISCharacter;

/**
 * 特定の条件に合致するJISCharacterのみを対象とするための
 * フィルタリングするインターフェース
 * 
 */
public interface TargetFilter {
    boolean isTarget(JISCharacter jisCharacter);

}
