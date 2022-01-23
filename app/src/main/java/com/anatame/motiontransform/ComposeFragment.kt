package com.anatame.motiontransform

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.Slide
import com.anatame.motiontransform.databinding.FragmentComposeBinding
import com.anatame.motiontransform.databinding.FragmentEmailBinding
import com.google.android.material.transition.MaterialContainerTransform


class ComposeFragment : Fragment() {

    private lateinit var binding: FragmentComposeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentComposeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterTransition = MaterialContainerTransform().apply {
            startView = requireActivity().findViewById(R.id.fab)
            endView = binding.composeCard
            duration = 300
            scrimColor = Color.TRANSPARENT
        }
        returnTransition = Slide().apply {
            duration = 300
            addTarget(R.id.composeCard)
        }
    }


}