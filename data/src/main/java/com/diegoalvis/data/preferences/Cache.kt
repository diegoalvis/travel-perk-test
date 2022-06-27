package com.diegoalvis.data.preferences

interface Cache {

    fun saveBoolean(key: String, value: Boolean)

    fun readBoolean(key: String, defValue: Boolean): Boolean

    fun saveString(key: String, value: String)

    fun readString(key: String): String?

    fun removeValue(key: String)

    fun saveObject(key: String, obj: Any)

    fun readObject(key: String): Any?

    fun clearAll()

}