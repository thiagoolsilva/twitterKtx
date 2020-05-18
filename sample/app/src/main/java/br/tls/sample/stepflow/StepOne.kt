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

package br.tls.sample.stepflow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.tls.sample.R
import br.tls.sample.util.sharedGraphViewModel
//import br.tls.sample.mainsample.StepOneDirections
import kotlinx.android.synthetic.main.fragment_step_one.*

/**
 * A simple [Fragment] subclass.
 * Use the [StepOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class StepOne : Fragment() {

    val sharedViewModel:SharedViewModel by sharedGraphViewModel(R.id.step_navigation)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("lopes", "onCreate")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_step_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNext.setOnClickListener {
            val userData = editText.text.toString()
            sharedViewModel.holdedData.add(userData)

            val direction =
                StepOneDirections.actionStepOneToStepTwo()
            findNavController().navigate(direction)
        }
    }

}
