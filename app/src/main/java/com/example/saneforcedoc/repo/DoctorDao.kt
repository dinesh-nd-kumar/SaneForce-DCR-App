package com.example.saneforcedoc.repo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    // Insert a product into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Doctor)

    // Insert a list of products
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<Doctor>)

    // Fetch all products from the database
    @Query("SELECT * FROM doctorsTable")
    suspend fun getAllProducts(): List<Doctor>

    // Fetch a product by ID
    @Query("SELECT * FROM doctorsTable WHERE Code = :productId")
    suspend fun getProductById(productId: String): Doctor?

    // Delete a product by ID
    @Query("DELETE FROM doctorsTable WHERE Code = :productId")
    suspend fun deleteProductById(productId: String)

    // Delete all products
    @Query("DELETE FROM doctorsTable")
    suspend fun deleteAllProducts()
}