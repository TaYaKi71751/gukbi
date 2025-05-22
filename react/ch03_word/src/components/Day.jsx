import { useParams } from "react-router-dom";
import Word from "./word";
import dummy from "../db/data.json";
import { useEffect, useState } from "react";
import useFetch from "../hooks/useFetch";

export default function Day(){
    //<Route path="/day/:day" element={<Day></Day>}/>
    const {day} = useParams();

    const words =useFetch(`http://localhost:3010/words?day=${day}`);
    // const [words,setWords]=useState([]);

    // useEffect(() => {
    //     fetch(`http://localhost:3010/words?day=${day}`)
    //     .then(res => {
    //         return res.json();
    //     })
    //     .then(data => {
    //         setWords(data);
    //     });
    // }, [day]);

    const wordList= words.filter(word=>word.day==day);

    return (
        <>
            <h2>Day {day}</h2>
            <table>
                <tbody>
                    {
                        wordList.map(word=>(
                           <Word word={word} key={word.id}/>
                        ))
                    }
                </tbody>            
            </table>
        </>
    );
}