package com.alwinsden.dino.googleAuthn.serverManager.tables

import org.jetbrains.exposed.v1.core.Table
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

const val MAX_VARCHAR_LENGTH = 128

data class UserInfoDataClass(
    val googleSubjectId: String,
    val userFullName: String,
    val userGoogleProfile: String,
    val userEmail: String
)

object UserInfo : Table("user_info") {
    @OptIn(ExperimentalUuidApi::class)
    val id = uuid("id").clientDefault { Uuid.random() }
    val googleSubjectId = varchar("user_google_subject", MAX_VARCHAR_LENGTH).uniqueIndex()
    val userFullName = varchar("user_info_full_name", MAX_VARCHAR_LENGTH)
    val userGoogleProfile = varchar(
        "user_profile_image", length = 1000,
    )
    val userEmail = varchar("user_info_email", MAX_VARCHAR_LENGTH)

    @OptIn(ExperimentalUuidApi::class)
    override val primaryKey = PrimaryKey(id)
}