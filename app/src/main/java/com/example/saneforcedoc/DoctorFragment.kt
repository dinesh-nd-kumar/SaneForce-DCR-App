package com.example.saneforcedoc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.saneforcedoc.databinding.FragmentDoctorBinding
import com.example.saneforcedoc.repo.Doctor
import com.example.saneforcedoc.repo.MyViewModel


class DoctorFragment : Fragment(),DoctorAdapter.ItemClickListener {


    private lateinit var binding: FragmentDoctorBinding
//    private val binding get() = _binding

    private lateinit var viewModel: MyViewModel
    lateinit var docAdapter : DoctorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoctorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
//        shopViewModel!!.loadData(activity)
        initRecycler()
        viewModel.getDcoLiveData().observe(viewLifecycleOwner){
            setRecycler(it)

        }










    }
    private fun setRecycler(list: List<Doctor>?){
        docAdapter.productList = list
        docAdapter.notifyDataSetChanged()
    }

    private fun initRecycler(){
        binding.doctorRV.apply {
            docAdapter = DoctorAdapter(this@DoctorFragment,null)
            adapter = docAdapter
//            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
//            addItemDecoration(DividerItemDecoration( context,DividerItemDecoration.VERTICAL))

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DoctorFragment().apply {


            }
    }

    override fun onItemClick(p: Doctor) {

    }
}