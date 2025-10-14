package string

class GroupAnagram {
    //time complexity is O(n × L log L)   +   O(n² × L) but O(n² × L) is dominant
//    fun groupAnagrams(strs: Array<String>): List<List<String>> {
//        val n = strs.size
//        val copyArr = strs.copyOf()
//        val set = HashSet<String>()
//        val ans = mutableListOf<List<String>>()
//
//        for (i in 0 until n) {
//            val name: (String) -> String = { elem ->
//                val str = elem.toCharArray()
//                str.sort()
//                String(str)
//            }
//            copyArr[i] = name(copyArr[i])
//            set.add(copyArr[i])
//        }
//
//        for (i in set) {
//            val list = mutableListOf<String>()
//            for (j in 0 until n) {
//                if (i == copyArr[j]) {
//                    list.add(strs[j])
//                }
//            }
//            ans.add(list)
//        }
//        return ans
//    }


    //time complexity is O(n x L log L)
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        //hashmap to store the hash map of sorted element and add the original element to its value
        //as a list
        val mpp = HashMap<String, MutableList<String>>()

        // moving through the array to compute the ans
        for (s in strs) {
            //returns a string as string which has its element sorted lexicographically
            val sortedString = s.toCharArray().apply { sort() }.concatToString()

            //check if the "sorted" value is present as a key; if absent, then executes the code
            //inside the lambda function, thus creating a new list and adding the original value to
            //the value of the key, otherwise, if present then skips the lambda function and executes
            //the rest of the code, that is , adding to the list in the value of the map.
            mpp.computeIfAbsent(sortedString) { mutableListOf() }.add(s)

            //difference between ".putIfAbsent()" and above is that ".putIfAbsent()" adds to the map
            //only if the value being chacked in the map is absent in the keys, is absent, then it adds
            //to the map; else, skips the adding of the value is present in the code.
        }

        return mpp.values.toList()
    }
}

fun main() {
    val strs = arrayOf("eat","tea","tan","ate","nat","bat")
    val ga = GroupAnagram()
    println(ga.groupAnagrams(strs).joinToString())
}