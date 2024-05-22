import {Card} from "antd";
import React from "react";
import styles from "./index.css"

const ContentComponent = ({params}) => {

    const carriageReturn = (string) => {
        let preparedResult = string.split('\\n');
        return (preparedResult.map((item, index) => {
            return <div key={`${index}_key`}>{item}</div>
        }));
    }

    return (
        <header className={styles}>
            {params.map((item, index) => {
                return <div key={`${index}_key`}
                            style={{
                                padding: '0.1%'
                            }}>
                    <Card>{item.publication_date}: <span>{carriageReturn(item.info)}</span></Card>
                </div>
            })}
        </header>
    )
}

export default ContentComponent;