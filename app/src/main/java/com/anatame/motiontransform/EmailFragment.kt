package com.anatame.motiontransform

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anatame.motiontransform.databinding.FragmentEmailBinding
import com.google.android.material.transition.MaterialContainerTransform


class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEmailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_host_fragment_activity_main
            duration = 600
            scrimColor = Color.TRANSPARENT
        }


        return root
    }


}