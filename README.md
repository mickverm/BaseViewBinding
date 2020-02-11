# Base ViewBinding

## About

[View binding][0] is a feature that allows you to more easily write code that interacts with views. Once view binding is enabled in a module, it generates a *binding class* for each XML layout file present in that module. An instance of a binding class contains direct references to all views that have an ID in the corresponding layout.

In most cases, view binding replaces `findViewById`.

This sample shows how **ViewBinding** can be used in base classes.

## Usage

### Activity

````kotlin
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
	setSupportActionBar(binding.toolbar)
    }

    ...
}
````


### Fragment

````kotlin
class ItemsFragment : BaseFragment<FragmentItemsBinding>(FragmentItemsBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvTitle = "Hello World!"
    }

    ...
}
````

### RecyclerView Adapter

````kotlin
class ItemsAdapter : BaseAdapter<ItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflateBinding(ItemItemBinding::inflate))
    }
	
    ...
	
    class ViewHolder(
        private val binding: ItemItemBinding
    ) : BaseViewHolder<ItemItemBinding>(binding) {

        fun bind(item: DummyItem) {
            binding.tvContent = item.content
        }

        ...

    }
}
````

[0]: https://developer.android.com/topic/libraries/view-binding
