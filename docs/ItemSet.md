# Item Set

Item set is a list of items with specified method of adding them to the player (these methods were described in the _Game_ chapter above.) Each set can specify an engine, wings, a list of usable items and a list of modifications. This is pretty straightforward once you know what these are (described in next chapters). Item sets are defined in _sets.yml_ file.

An item set can optionally have `class_name` value, which will be used as class name if this set is applied to the player. If more than one item set with a name is applied, the last one will be used.

Each specified item can have `max` value which limits the maximum amount of this item a player can have and `min` value which is the minimum limit below which selling is not possible.

The `refills` setting controls whenever all player's items will be refilled when applying this item set. Generally you don't want that - buying a rocket shouldn't fix your wings, right? This can be useful however if you have buttons in your waiting room. With this setting you can give filled items even if players have additional modifications which increase some items' properties.

```
items:
  item_set_name:
    class_name: [translatable text]
    engine: [engine name]
    wings: [wings name]
    items:
    - [item name]
    modifications:
    - [modification name]
    refills: [true/false]
```

## Item set settings

* `class_name` (**optional**) is the name of the class; the player's class will have this name if he chooses this item set. If the player's kit doesn't have any set with a name, the player won't have a class name.
* `engine` (**optional**) is the name of the Engine, as defined in _engines.yml_.
* `wings` (**optional**) is the name of the Wings, as defined in _wings.yml_.
* `items` (**optional**) is the list of items in this set, as defined in _items.yml_.
* `modifications` (**optional**) is the list of Modifications, as defined in _modifications.yml_.
* `refils` (**default: false**) whenever applying this set will refill all items
