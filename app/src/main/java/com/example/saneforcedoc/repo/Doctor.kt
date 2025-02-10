package com.example.saneforcedoc.repo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class DocResponse (

    @SerializedName("success"  ) var success  : Boolean?            = null,
    @SerializedName("message"  ) var message  : String?             = null,
    @SerializedName("response" ) var response : List<Doctor> = listOf()

)

data class DocPostBody (

    @SerializedName("Master_Name"       ) var MasterName      : String = "Doctor_Master",
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


@Entity(tableName = "doctorsTable")
data class Doctor (


    @PrimaryKey
    @SerializedName("Code"                       ) var Code                    : String = "",
    @SerializedName("Name"                       ) var Name                    : String? = null,
    @SerializedName("Town_Code"                  ) var TownCode                : String? = null,
    @SerializedName("Town_Name"                  ) var TownName                : String? = null,
    @SerializedName("HQ_SF_Code"                 ) var HQSFCode                : String? = null,
    @SerializedName("HQ_Division_Code"           ) var HQDivisionCode          : String? = null,
    @SerializedName("Doctor_Category_Code"       ) var DoctorCategoryCode      : String? = null,
    @SerializedName("Doctor_Category_Name"       ) var DoctorCategoryName      : String? = null,
    @SerializedName("Doctor_Speciality_Code"     ) var DoctorSpecialityCode    : String? = null,
    @SerializedName("Doctor_Speciality_Name"     ) var DoctorSpecialityName    : String? = null,
    @SerializedName("Doctor_Class_Code"          ) var DoctorClassCode         : String? = null,
    @SerializedName("Doctor_Class_Name"          ) var DoctorClassName         : String? = null,
    @SerializedName("Doctor_DOB"                 ) var DoctorDOB               : String? = null,
    @SerializedName("Doctor_DOW"                 ) var DoctorDOW               : String? = null,
    @SerializedName("Total_Visit_Count"          ) var TotalVisitCount         : String? = null,
    @SerializedName("Doctor_Month_Visit_Count"   ) var DoctorMonthVisitCount   : String? = null,
    @SerializedName("Product_Brand_Code"         ) var ProductBrandCode        : String? = null,
    @SerializedName("Doctor_Mapped_Product_Code" ) var DoctorMappedProductCode : String? = null,
    @SerializedName("Doctor_Phone_No"            ) var DoctorPhoneNo           : String? = null,
    @SerializedName("Geo_Tag_Count"              ) var GeoTagCount             : String? = null,
    @SerializedName("Geo_Total_Tagged_Count"     ) var GeoTotalTaggedCount     : String? = null,
    @SerializedName("Hospital_Code"              ) var HospitalCode            : String? = null,
    @SerializedName("Hospital_Name"              ) var HospitalName            : String? = null

)
