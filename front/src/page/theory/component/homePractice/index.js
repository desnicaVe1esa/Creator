import {Card} from "antd";
import React from "react";

const HomePractice = ({params}) => {

    const carriageReturn = (string) => {
        let preparedResult = string.split('\\n');
        return (preparedResult.map((item, index) => {
            return <div key={`${index}_key`}>{item}</div>
        }));
    }

    return (
        params.map((item, index) => {
            return <div key={`${index}_key`}
                    style={{
                        padding: '0.1%'
                    }}>
                    <Card>{item.publication_date}: <span>{carriageReturn(item.info)}</span></Card>
                </div>

        })
    )
}

export default HomePractice;