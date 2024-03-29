package com.example.poetic.model

import kotlinx.serialization.Serializable

@Serializable
data class Poem(
    val title: String,
    val author: String,
    val lines: Array<String>,
    val linecount: String
)

class Datasource {
    val mockPoem = Poem(
        title = "Sonnet 1: From fairest creatures we desire increase",
    author = "William Shakespeare",
    lines = arrayOf(
    "From fairest creatures we desire increase, ",
    "That thereby beauty's rose might never die,",
    "But as the riper should by time decease, ",
    "His tender heir might bear his memory",
    "But thou contracted to thine own bright eyes,",
    "Feed'st thy light's flame with self-substantial fuel,",
    "Making a famine where abundance lies,",
    "Thy self thy foe, to thy sweet self too cruel:",
    "Thou that art now the world's fresh ornament,",
    "And only herald to the gaudy spring,",
    "Within thine own bud buriest thy content,",
    "And tender churl mak'st waste in niggarding:",
    " Pity the world, or else this glutton be,",
    " To eat the world's due, by the grave and thee."
    ),
    linecount = "14")
}
