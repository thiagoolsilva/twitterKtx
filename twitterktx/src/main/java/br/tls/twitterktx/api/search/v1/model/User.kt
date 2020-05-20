/*
 * Copyright (c) 2020  Thiago Lopes da Silva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.tls.twitterktx.api.search.v1.model

/**
 * The user twitter representation. For more details about it go to https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/user-object
 */
data class User (

    val id : Number,
    val id_str : String,
    val name : String,
    val screen_name : String,
    val location : String?,
    val derived: List<GeoData>?,
    val url : String?,
    val description : String?,
    val protected : Boolean,
    val verified : Boolean,
    val followers_count : Int,
    val friends_count : Int,
    val listed_count : Int,
    val statuses_count : Int,
    val favourites_count : Int,
    val created_at : String,
    val profile_banner_url : String,
    val profile_image_url_https : String,
    val default_profile : Boolean,
    val default_profile_image : Boolean,
    val withheld_in_countries: List<String>?,
    val withheld_scope: String?
)