package component

import csstype.*
import data.Grade
import react.FC
import react.Props
import emotion.react.css
import react.dom.html.ReactHTML.option
import react.dom.html.ReactHTML.select
import react.useContext

external interface GradeProps : Props {
    var grade: Grade
    var setGrade: (Grade) -> Unit
}


val CGrade =FC<GradeProps>("Grade") { props ->
    val list = listOf(1,2,3,4,5)
    select {
        //css{ backgroundColor = useContext(primer).second[props.grade-1] }
        onChange = { props.setGrade(it.target.value.toInt()) }
        value = props.grade.toString()
        list.mapIndexed { index, it ->
            option {
                //css{ backgroundColor = useContext(primer).second[index]}
                +it.toString()
            }
        }
    }
}