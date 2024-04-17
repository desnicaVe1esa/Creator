import React, {useState} from "react";
import {Col, Input, Row} from "antd";
import {Typography} from 'antd';

const {Title} = Typography;

const Main = () => {

    const [inputValue, setInputValue] = useState('');

    const onPressEnter = () => {
        fetch('http://localhost:8080/creator/createTemplates', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: inputValue
        }).then(r => {
        });
    }

    return (
        <div>
            <Row>
                <Title style={{color: 'white'}}
                       level={2}>
                    Добро пожаловать в Creator - сервис создания заготовок для решения задач
                    с&ensp;<a href="https://www.codewars.com">www.codewars.com</a>
                </Title>
            </Row>
            <Row>
                <Col>
                    <Input placeholder="Скопируйте ID задачи и нажмите 'Enter'"
                           onPressEnter={onPressEnter}
                           type="text" value={inputValue}
                           onChange={(e) => setInputValue(e.target.value)}
                           style={{
                               width: 285,
                           }}>
                    </Input>
                </Col>
            </Row>
        </div>
    );
}
export default Main;