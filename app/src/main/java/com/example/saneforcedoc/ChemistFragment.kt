package com.example.saneforcedoc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.saneforcedoc.databinding.FragmentChemistBinding
import com.example.saneforcedoc.repo.Chemist
import com.example.saneforcedoc.repo.MyViewModel

class ChemistFragment : Fragment(),ChemistAdapter.ItemClickListener {


    private lateinit var binding: FragmentChemistBinding
//    private val binding get() = _binding

    private lateinit var viewModel: MyViewModel
    lateinit var docAdapter : ChemistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChemistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
//        shopViewModel!!.loadData(activity)
        initRecycler()
        viewModel.getChemistLiveData().observe(viewLifecycleOwner){
            setRecycler(it)

        }




    }
    private fun setRecycler(list: List<Chemist>?){
        docAdapter.productList = list
        docAdapter.notifyDataSetChanged()
    }

    private fun initRecycler(){
        binding.chemistRV.apply {
            docAdapter = ChemistAdapter(this@ChemistFragment,null)
            adapter = docAdapter
//            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
//            addItemDecoration(DividerItemDecoration( context,DividerItemDecoration.VERTICAL))

        }
    }

    override fun onItemClick(p: Chemist) {

    }


}