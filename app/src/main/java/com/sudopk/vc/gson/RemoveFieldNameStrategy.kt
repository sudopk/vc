package com.sudopk.vc.gson

import com.google.gson.FieldNamingStrategy

import java.lang.reflect.Field

class RemoveFieldNameStrategy : FieldNamingStrategy {
  override fun translateName(f: Field): String {
    val name = f.name.toCharArray()
    var offset = 0
    if (name.size >= 2 && name[0] == 'm' && Character.isUpperCase(name[1])) {
      name[1] = Character.toLowerCase(name[1])
      offset = 1
    }
    return String(name, offset, name.size - offset)
  }
}
