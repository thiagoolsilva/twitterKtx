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

package br.tls.twitterktx.api.search.model

data class Statuses (

	val created_at : String,
	val id : Number,
	val id_str : String,
	val text : String,
	val truncated : Boolean,
	val entities : Entities?,
	val metadata : Metadata?,
	val source : String,
	val in_reply_to_status_id : String,
	val in_reply_to_status_id_str : String,
	val in_reply_to_user_id : String,
	val in_reply_to_user_id_str : String,
	val in_reply_to_screen_name : String,
	val user : User?,
	val geo : String,
	val coordinates : String,
	val place : Place?,
	val contributors : String,
	val is_quote_status : Boolean,
	val retweet_count : Int,
	val favorite_count : Int,
	val favorited : Boolean,
	val retweeted : Boolean,
	val lang : String
)