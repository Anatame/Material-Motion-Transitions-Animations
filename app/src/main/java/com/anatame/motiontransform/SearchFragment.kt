package com.anatame.motiontransform

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionManager
import com.anatame.motiontransform.databinding.FragmentSearchBinding
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true).apply {
            duration = 300
        }
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, false).apply {
            duration = 300
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            button.setOnClickListener {
                expandBtn()
            }
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun expandBtn(){
        binding.button.visibility = View.INVISIBLE
        binding.expandedCard.visibility = View.VISIBLE
        val transform = MaterialContainerTransform().apply {
            startView = binding.button
            endView = binding.expandedCard
            scrimColor = Color.TRANSPARENT
            endElevation = 8.0f
            addTarget(binding.expandedCard)
        }

        TransitionManager.beginDelayedTransition(binding.searchLayout, transform)
    }


}