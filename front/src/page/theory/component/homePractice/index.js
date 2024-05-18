import {Card} from "antd";
import React from "react";

const HomePractice = ({params}) => {

    return (
        params.map((item, index) => {
            return <Card key={`${index}_card`}>{item.publication_date}: {item.info}</Card>
        })
    )
}

export default HomePractice;