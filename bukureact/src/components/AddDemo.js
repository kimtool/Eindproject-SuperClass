import React, {useState} from 'react';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';

const AddDemo = (props) => {
//boolean typed state to define the visibility of the dialog form
    const [open, setOpen] = useState(false);
    const [demo, setDemo] = useState({
        title:'', description: ''});

//Open the modal form
    const handleClickopen = () => {
        setOpen(true);
    }
//Close the modal form
    const handleClose = () => {
        setOpen(false);
    }

    const handleChange = (event) => {
        setDemo({...demo, [event.target.name]: event.target.value});
      }

//save demo and close modal form
    const handleSave = () => {
        props.addDemo(demo);
        handleClose();
    }

    return(
        <div>
            <button style ={{margin:10}} onClick={handleClickopen}>Add Demo</button>
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>New Demo</DialogTitle>
                <DialogContent>
                    <input type="text" name="title" placeholder="Title" value={demo.title} onChange={handleChange}/><br/>
                    <input type="text" name="description" placeholder="Description" value={demo.description} onChange={handleChange}/>
                </DialogContent>
                <DialogActions>
                    <button onClick={handleSave}>Save</button>
                    <button onClick={handleClose}>Cancel</button>
                </DialogActions>
            </Dialog>
        </div>
    );
}

export default AddDemo;