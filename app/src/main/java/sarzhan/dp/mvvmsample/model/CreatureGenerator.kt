package sarzhan.dp.mvvmsample.model

class CreatureGenerator {

    fun generateCreature (attributes: CreatureAttributes, name:String = "",
                          drawable:Int = 0):Creature {
        val hitPoints = 5* attributes.intelligense +
                3* attributes.srtength +
                4* attributes.endurance
        return Creature(attributes,hitPoints,name,drawable)
    }
}