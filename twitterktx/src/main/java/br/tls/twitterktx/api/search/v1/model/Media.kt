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

data class Media (
    val display_url:String,
    val expanded_url:String,
    val id:Number,
    val id_str:String,
    val indices:List<Int>,
    val media_url:String,
    val media_url_https:String,
//    val sizes:
    val source_status_id:Number?,
    val source_status_id_str:String?,
    val type:String,
    val url:String

)