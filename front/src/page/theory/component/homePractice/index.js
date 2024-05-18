import {Card} from "antd";
import React from "react";

const HomePractice = ({params}) => {

    const carriageReturn = (string) => {
        return string.replace('1n', '<p>').replace('2n', '</p>');
    }

    return (
        params.map((item, index) => {
            return <div key={`${index}_key`} style={{padding: '0.1%'}}><Card>{item.publication_date}: {carriageReturn(item.info)}</Card></div>
        })
    )
}

export default HomePractice;