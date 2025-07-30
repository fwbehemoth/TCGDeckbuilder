package com.valerunners.tcgdeckbuilder.utilities

import com.valerunners.tcgdeckbuilder.R

fun GetManaSymbolDrawableId(manaSymbolText: String): Int{
    var manaSymbolDrawableId: Int
    val scrubbedManaSymbol = manaSymbolText
        .replace("{","")
        .replace("}","")
        .lowercase()

    when(scrubbedManaSymbol){
        "0" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_0
        }
        "1" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_1
        }
        "2" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_2
        }
        "3" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_3
        }
        "4" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_4
        }
        "5" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_5
        }
        "6" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_6
        }
        "7" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_7
        }
        "8" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_8
        }
        "9" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_9
        }
        "10" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_10
        }
        "11" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_11
        }
        "12" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_12
        }
        "13" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_13
        }
        "14" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_14
        }
        "15" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_15
        }
        "16" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_16
        }
        "17" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_8
        }
        "18" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_18
        }
        "19" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_19
        }
        "20" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_20
        }
        "w" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_w
        }
        "u" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_u
        }
        "b" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_b
        }
        "r" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_r
        }
        "g" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_g
        }
        "x" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_x
        }
        "c" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_c
        }
        "s" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_s
        }
        "w/u" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_wu
        }
        "w/b" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_wb
        }
        "b/r" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_br
        }
        "b/g" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_bg
        }
        "u/b" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_ub
        }
        "u/r" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_ur
        }
        "r/g" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_rg
        }
        "r/w" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_rw
        }
        "g/w" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_gw
        }
        "g/u" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_gu
        }
        "w/u/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_wup
        }
        "w/b/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_wbp
        }
        "b/g/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_bgp
        }
        "b/r/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_brp
        }
        "g/u/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_gup
        }
        "g/w/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_gwp
        }
        "r/g/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_rgp
        }
        "r/w/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_rwp
        }
        "u/b/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_ubp
        }
        "u/r/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_brp
        }
        "c/w" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_cw
        }
        "c/u" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_cu
        }
        "c/b" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_cb
        }
        "c/r" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_cr
        }
        "c/g" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_cg
        }
        "2/w" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_2w
        }
        "2/u" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_2u
        }
        "2/b" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_2b
        }
        "2/r" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_2r
        }
        "2/g" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_2g
        }
        "w/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_wp
        }
        "u/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_up
        }
        "b/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_bp
        }
        "r/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_rp
        }
        "g/p" -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_gp
        }
        else -> {
            manaSymbolDrawableId = R.drawable.mana_symbol_inverteds
        }
    }
    return manaSymbolDrawableId
}