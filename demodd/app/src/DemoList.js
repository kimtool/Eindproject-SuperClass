import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class DemoList extends Component {

    constructor(props) {
        super(props);
        this.state = {fileEntitys: [], isLoading: true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('api/demos/all')
            .then(response => response.json())
            .then(data => this.setState({fileEntitys: data, isLoading: false}));
    }

    async remove(id) {
        await fetch(`/api/demos/fileEntity/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedDemos = [...this.state.fileEntitys].filter(i => i.id !== id);
            this.setState({fileEntitys: updatedDemos});
        });
    }

    render() {
        const {fileEntitys, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const demoList = fileEntitys.map(fileEntity => {
            return <tr key={fileEntity.id}>
                <td style={{whiteSpace: 'nowrap'}}>{fileEntity.fileName}</td>
                <td>{fileEntity.id}</td>
                <td>{}
                </td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/api/demos/fileEntity/" + fileEntity.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(fileEntity.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                    </div>
                    <h3>Demolist</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="20%">ID</th>
                            <th width="20%">Name</th>
                            <th>Data</th>
                            <th width="10%">events</th>
                        </tr>
                        </thead>
                        <tbody>
                        {demoList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default DemoList;