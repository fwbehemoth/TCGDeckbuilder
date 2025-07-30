package com.valerunners.tcgdeckbuilder

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class ScryfallBaseData(
    @SerializedName("data")
    val Data: List<ScryfallCard>
)

@Serializable
data class ScryfallCard(
    @SerializedName("id")
    val id : String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("image_uris")
    val imageUrls: ScryfallImageUrls?,
    @SerializedName("mana_cost")
    val manaCost: String?,
    @SerializedName("cmc")
    val cmc: String?,
    @SerializedName("type_line")
    val typeLine: String?,
    @SerializedName("power")
    val power: String?,
    @SerializedName("toughness")
    val toughness: String?,
    @SerializedName("oracle_text")
    val oracleText: String?,
    @SerializedName("loyality")
    val loyality: String?,
    @SerializedName("colors")
    val colors: List<String>?,
    @SerializedName("color_identity")
    val colorIdentity: List<String>?,
    @SerializedName("legalities")
    val legalities: ScryfallLegalities?,
    @SerializedName("games")
    val gamesList: List<String>?,
    @SerializedName("game_changer")
    val gameChanger: String?,
    @SerializedName("reserved")
    val reserved: String?,
    @SerializedName("set")
    val setAbbreviation: String?,
    @SerializedName("set_name")
    val setName: String?,
    @SerializedName("set_type")
    val setType: String?,
    @SerializedName("rarity")
    val rarity: String?,
    @SerializedName("flavor_text")
    val flavorText: String?,
    @SerializedName("artist")
    val artist: String?,
    )

@Serializable
data class ScryfallImageUrls(
    @SerializedName("small")
    val small: String?,
    @SerializedName("normal")
    val normal: String?,
    @SerializedName("large")
    val large: String?,
    @SerializedName("png")
    val png: String?,
    @SerializedName("art_crop")
    val artCrop: String?,
    @SerializedName("border_crop")
    val borderCrop: String?,
)

@Serializable
data class ScryfallLegalities(
    @SerializedName("standard")
    val standard: String?,
    @SerializedName("future")
    val future: String?,
    @SerializedName("historic")
    val historic: String?,
    @SerializedName("timeless")
    val timeless: String?,
    @SerializedName("gladiator")
    val gladiator: String?,
    @SerializedName("pioneer")
    val pioneer: String?,
    @SerializedName("explorer")
    val explorer: String?,
    @SerializedName("modern")
    val modern: String?,
    @SerializedName("legacy")
    val legacy: String?,
    @SerializedName("pauper")
    val pauper: String?,
    @SerializedName("vintage")
    val vintage: String?,
    @SerializedName("penny")
    val penny: String?,
    @SerializedName("commander")
    val commander: String?,
    @SerializedName("oathbreaker")
    val oathbreaker: String?,
    @SerializedName("standardbrawl")
    val standardbrawl: String?,
    @SerializedName("brawl")
    val brawl: String?,
    @SerializedName("alchemy")
    val alchemy: String?,
    @SerializedName("paupercommander")
    val paupercommander: String?,
    @SerializedName("duel")
    val duel: String?,
    @SerializedName("oldschool")
    val oldschool: String?,
    @SerializedName("premodern")
    val premodern: String?,
    @SerializedName("predh")
    val predh: String?,
)
