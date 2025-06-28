package com.example.fw.common.codepoints;

import org.terasoluna.gfw.common.codepoints.CodePoints;

/**
 *  特殊カタカナ（1面5区）の文字集合を表すクラス
 */
public final class JIS_X_0213_SpecialKatakana extends CodePoints {
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ
     */
    public JIS_X_0213_SpecialKatakana() {
	        super(t0(new Integer[7]));
    }

    private static Integer[] t0(Integer[] cp) {
        cp[0] = 0x30AB; // カ゚(01-05-87) 
        cp[1] = 0x309A; // カ゚(01-05-87) 
        cp[2] = 0x30AD; // キ゚(01-05-88) 
        cp[3] = 0x309A; // キ゚(01-05-88) 
        cp[4] = 0x30AF; // ク゚(01-05-89) 
        cp[5] = 0x309A; // ク゚(01-05-89) 
        cp[6] = 0x30B1; // ケ゚(01-05-90) 
        cp[7] = 0x309A; // ケ゚(01-05-90) 
        cp[8] = 0x30B3; // コ゚(01-05-91) 
        cp[9] = 0x309A; // コ゚(01-05-91) 
        cp[10] = 0x30BB; // セ゚(01-05-92) 
        cp[11] = 0x309A; // セ゚(01-05-92) 
        cp[12] = 0x30C4; // ツ゚(01-05-93) 
        cp[13] = 0x309A; // ツ゚(01-05-93) 
        cp[14] = 0x30C8; // ト゚(01-05-94) 
        cp[15] = 0x309A; // ト゚(01-05-94) 
        return cp;
    }
}   