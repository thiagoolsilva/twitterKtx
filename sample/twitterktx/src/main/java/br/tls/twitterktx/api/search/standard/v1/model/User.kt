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

package br.tls.twitterktx.api.search.standard.v1.model

data class User (

    val id : Number,
    val id_str : String,
    val name : String,
    val screen_name : String,
    val location : String,
    val description : String,
    val url : String,
    val entities : Entities,
    val protected : Boolean,
    val followers_count : Int,
    val friends_count : Int,
    val listed_count : Int,
    val created_at : String,
    val favourites_count : Int,
    val utc_offset : String,
    val time_zone : String,
    val geo_enabled : Boolean,
    val verified : Boolean,
    val statuses_count : Int,
    val lang : String,
    val contributors_enabled : Boolean,
    val is_translator : Boolean,
    val is_translation_enabled : Boolean,
    val profile_background_color : String,
    val profile_background_image_url : String,
    val profile_background_image_url_https : String,
    val profile_background_tile : Boolean,
    val profile_image_url : String,
    val profile_image_url_https : String,
    val profile_banner_url : String,
    val profile_link_color : String,
    val profile_sidebar_border_color : String,
    val profile_sidebar_fill_color : String,
    val profile_text_color : String,
    val profile_use_background_image : Boolean,
    val has_extended_profile : Boolean,
    val default_profile : Boolean,
    val default_profile_image : Boolean,
    val following : String,
    val follow_request_sent : String,
    val notifications : String,
    val translator_type : String
)