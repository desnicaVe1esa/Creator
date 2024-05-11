import React, {useState} from "react";
import {Button, Col, ConfigProvider, Input, Row, Select} from "antd";
import {Typography} from 'antd';
import {TinyColor} from '@ctrl/tinycolor';
import axios from 'axios';

const {Title} = Typography;

const gradient = ['rgba(4,210,32,1)', 'rgba(0,0,0,1)'];
const getHoverColors = (colors) =>
    colors.map((color) => new TinyColor(color).lighten(5).toString());
const getActiveColors = (colors) =>
    colors.map((color) => new TinyColor(color).darken(5).toString());

const Main = () => {
    const [taskId, setTaskId] = useState('');
    /* Все доступные языки */
    const [languages, setLanguages] = useState([]);
    /* Выбранные языки */
    const [languagesForSolution, setLanguagesForSolution] = useState([]);
    /* Контейнер для загрузки языков */
    const options = [];

    const onClickLoadLanguages = async () => {
        try {
            const response = await axios.get(`https://www.codewars.com/api/v1/code-challenges/${taskId}`)
            setLanguages(response.data.languages)
        } catch (error) {
            console.warn('Ошибка при получении данных:', error);
        }
    }

    /* Данная проверка ставится потому, что когда fetchData вызывается впервые, languages всё ещё пустой массив,
       потому что useState инициализирует его начальным значением. После того как запрос выполнен и setLanguages
       вызывается с новыми данными, languages обновляется новым значением, и последующие вызовы fetchData будут
       видеть уже обновлённое значение. */
    if (languages !== undefined) {
        for (let i = 0; i < languages.length; i++) {
            options.push({
                value: languages[i],
                label: languages[i],
            });
        }
    }

    const onClickCreateTemplates = () => {
        fetch('http://localhost:8080/creator/createTemplates', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({taskId, languagesForSolution})
        })
            .then(response => response.json())
            .then(data => console.log(data))
            .catch(error => console.error('Ошибка при выполнении запроса:', error));
    }

    return (
        <div style={{
            backgroundImage: `url(${process.env.PUBLIC_URL + 'img/background_main.jpg'})`,
            backgroundPosition: 'center',
            backgroundSize: 'cover',
            backgroundRepeat: 'no-repeat',
            width: '100vw',
            height: '100vh'
        }}>
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Title style={{color: 'white'}}
                       level={2}>
                    Добро пожаловать в Creator - сервис создания заготовок для решения задач
                    с&ensp;<a href="https://www.codewars.com">www.codewars.com</a>
                </Title>
            </Row>
            <Row>
                <Col span={12}>
                    {/** Создание шаблона **/}
                    <Row>
                        <Title style={{color: 'white'}}
                               level={3}>
                            Алгоритм действий:
                        </Title>
                    </Row>
                    <Row>
                        <Col>
                            <p style={{color: 'white'}}>1.&ensp;</p>
                        </Col>
                        <Col style={{paddingBottom: '1%'}}>
                            <Input placeholder="Скопируйте ID задачи"
                                   type="text" value={taskId}
                                   onChange={(e) => setTaskId(e.target.value)}
                                   style={{width: 200}}>
                            </Input>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <p style={{color: 'white'}}>2.&ensp;</p>
                        </Col>
                        <Col style={{paddingBottom: '1%'}}>
                            <ConfigProvider
                                theme={{
                                    components: {
                                        Button: {
                                            colorPrimary: `linear-gradient(116deg,  ${gradient.join(', ')})`,
                                            colorPrimaryHover: `linear-gradient(116deg, ${getHoverColors(gradient).join(', ')})`,
                                            colorPrimaryActive: `linear-gradient(116deg, ${getActiveColors(gradient).join(', ')})`,
                                            lineWidth: 0,
                                        },
                                    },
                                }}
                            >
                                <Button style={{color: 'white'}}
                                        type="primary"
                                        onClick={onClickLoadLanguages}>
                                    Нажмите, чтобы загрузить дуступные языки программирования для решения задачи
                                </Button>
                            </ConfigProvider>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <p style={{color: 'white'}}>3.&ensp;</p>
                        </Col>
                        <Col style={{paddingBottom: '1%'}}>
                            <Select
                                mode="multiple"
                                placeholder="Выберите языки программирования, на которых будите решать задачу"
                                onChange={(e) => setLanguagesForSolution(e)}
                                style={{width: 510}}
                                options={options}
                            />
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <p style={{color: 'white'}}>4.&ensp;</p>
                        </Col>
                        <Col style={{paddingBottom: '1%'}}>
                            <ConfigProvider
                                theme={{
                                    components: {
                                        Button: {
                                            colorPrimary: `linear-gradient(116deg,  ${gradient.join(', ')})`,
                                            colorPrimaryHover: `linear-gradient(116deg, ${getHoverColors(gradient).join(', ')})`,
                                            colorPrimaryActive: `linear-gradient(116deg, ${getActiveColors(gradient).join(', ')})`,
                                            lineWidth: 0,
                                        },
                                    },
                                }}
                            >
                                <Button style={{color: 'white'}}
                                        type="primary"
                                        onClick={onClickCreateTemplates}>
                                    Создать заготовки
                                </Button>
                            </ConfigProvider>
                        </Col>
                    </Row>
                </Col>
                <Col span={12} style={{display: 'flex', justifyContent: 'right'}}>
                    {/** Обзор **/}
                    <img src={"/gif/review.gif"}
                         alt={'review'}
                         height={'250px'}
                         width={'400'}
                    />
                </Col>
            </Row>
            <Row style={{display: 'flex', paddingTop: '19%', paddingRight: '3%', justifyContent: 'center'}}>
                <a href="/theory">Немного теории и полезной информации</a>
            </Row>
        </div>)
}
export default Main;