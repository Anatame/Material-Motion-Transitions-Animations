package com.anatame.motiontransform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.anatame.motiontransform.databinding.FragmentHomeBinding
import com.google.android.material.transition.MaterialElevationScale

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.card1.setOnClickListener{
            onCardClicked()
        }

        return binding.root
    }

    fun onCardClicked(){
        exitTransition = MaterialElevationScale(false).apply {
            duration = 600
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = 600
        }

        val extras = FragmentNavigatorExtras(binding.card1 to "card1")
        val directions = HomeFragmentDirections.actionHomeFragmentToEmailFragment()
        findNavController().navigate(directions, extras)
    }

}