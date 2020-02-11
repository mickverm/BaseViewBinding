package be.mickverm.viewbinding.ui.fragments.items

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import be.mickverm.viewbinding.data.dummy.DummyContent
import be.mickverm.viewbinding.databinding.FragmentItemsBinding
import be.mickverm.viewbinding.ui.base.BaseFragment

class ItemsFragment : BaseFragment<FragmentItemsBinding>(FragmentItemsBinding::inflate) {

    companion object {
        fun newInstance() = ItemsFragment()
    }

    private var columnCount = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding.list) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = ItemsAdapter(
                DummyContent.ITEMS
            )
        }
    }
}