package com.valerunners.tcgdeckbuilder.datamodels.edhrec

import com.google.gson.annotations.SerializedName

data class EdhrecCommander(
    @SerializedName("creature")
    val creature: Int,
    @SerializedName("instant")
    val instant: Int,
    @SerializedName("sorcery")
    val sorcery: Int,
    @SerializedName("artifact")
    val artifact: Int,
    @SerializedName("enchantment")
    val enchantment: Int,
    @SerializedName("battle")
    val battle: Int,
    @SerializedName("planeswalker")
    val planeswalker: Int,
    @SerializedName("land")
    val land: Int,
    @SerializedName("basic")
    val basic: Int,
    @SerializedName("nonbasic")
    val nonbasic: Int,
    @SerializedName("container")
    val container: EdhrecContainer,
    @SerializedName("header")
    val header: String,
)

data class EdhrecContainer(
    @SerializedName("json_dict")
    val jsonDict: EdhrecJsonDict,
)

data class EdhrecJsonDict(
    @SerializedName("cardlists")
    val cardLists: List<EdhrecCardLists>,
)

data class EdhrecCardLists(
    @SerializedName("cardviews")
    val cardViews: List<EdhrecCardViews>,
    @SerializedName("header")
    val header: String,
    @SerializedName("tag")
    val tag: String,
)

data class EdhrecCardViews(
    val name: String,
    @SerializedName("sanitized")
    val sanitized: String,
    @SerializedName("sanitized_wo")
    val sanitized_wo: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("synergy")
    val synergy: Float,
    @SerializedName("inclusion")
    val inclusion: Int,
    @SerializedName("label")
    val label: String,
    @SerializedName("num_decks")
    val num_decks: Int,
    @SerializedName("potential_decks")
    val potential_decks: Int,
)