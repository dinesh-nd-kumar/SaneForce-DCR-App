package com.example.saneforcedoc.repo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ChemistResponse (

    @SerializedName("success"  ) var success  : Boolean?            = null,
    @SerializedName("message"  ) var message  : String?             = null,
    @SerializedName("response" ) var response : List<Chemist> = listOf()

)
data class ChemistPostBody (

    @SerializedName("Master_Name"       ) var MasterName      : String = "Chemist_Master",
    @SerializedName("SF_Code"           ) var SFCode          : String = "MR0005",
    @SerializedName("HQ_SF_Code"        ) var HQSFCode        : String = "MR0005",
    @SerializedName("SF_Type_Code"      ) var SFTypeCode      : String = "1",
    @SerializedName("SF_State_Code"     ) var SFStateCode     : String = "4",
    @SerializedName("Division_Code"     ) var DivisionCode    : String = "1",
    @SerializedName("Sub_Division_Code" ) var SubDivisionCode : String = "1",
    @SerializedName("Current_Date"      ) var CurrentDate     : String = "2024-12-15 00:00:00",
    @SerializedName("Mode"              ) var Mode            : String = "Android-App",
    @SerializedName("Language"          ) var Language        : String = "EN",
    @SerializedName("App_Version"       ) var AppVersion      : String = "1.0"

)


@Entity(tableName = "chemistTable")
data class Chemist (

    @PrimaryKey
    @SerializedName("Code"                   ) var Code                : String = "",
    @SerializedName("Name"                   ) var Name                : String? = null,
    @SerializedName("Town_Code"              ) var TownCode            : String? = null,
    @SerializedName("Town_Name"              ) var TownName            : String? = null,
    @SerializedName("HQ_SF_Code"             ) var HQSFCode            : String? = null,
    @SerializedName("HQ_Division_Code"       ) var HQDivisionCode      : String? = null,
    @SerializedName("Chemist_Category_Code"  ) var ChemistCategoryCode : String? = null,
    @SerializedName("Chemist_Phone_No"       ) var ChemistPhoneNo      : String? = null,
    @SerializedName("Chemist_Mobile_No"      ) var ChemistMobileNo     : String? = null,
    @SerializedName("Chemist_Email_Id"       ) var ChemistEmailId      : String? = null,
    @SerializedName("Chemist_Fax"            ) var ChemistFax          : String? = null,
    @SerializedName("Geo_Tag_Count"          ) var GeoTagCount         : String? = null,
    @SerializedName("Geo_Total_Tagged_Count" ) var GeoTotalTaggedCount : String? = null

)