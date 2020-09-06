package cl.desafiolatam.superheroes.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.desafiolatam.superheroes.R
import cl.desafiolatam.superheroes.model.api.HeroeListMini
import cl.desafiolatam.superheroes.viewmodel.HeroeViewModel
import kotlinx.android.synthetic.main.fragment_heroe_list.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HeroeListFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private var heroList = ArrayList<HeroeListMini>()
    private lateinit var adapter: AdapterHeroe
    private lateinit var heroeViewModel : HeroeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_heroe_list, container, false)
    }

    companion object {

       @JvmStatic fun newInstance(param1: String, param2: String) =
            HeroeListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AdapterHeroe(heroList)
        heroeRecycler.adapter = adapter
        val heroeViewModel : HeroeViewModel by activityViewModels()

        heroeViewModel.listHero.observe(viewLifecycleOwner, Observer {
            adapter.updateItems(it)
        })
        adapter.heroeSelected.observe(viewLifecycleOwner, Observer {
            Log.d("lifeCycleaOwner", "heroe selecionado $it")
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragments,HeroeDetailFragment.newInstance("",""), "detail")
                .addToBackStack("detail")
                .commit()


        })  }

}