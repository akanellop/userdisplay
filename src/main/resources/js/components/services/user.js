const baseUrl = "http://localhost:8080/api/user"
import axios from "axios";
const user= {};


user.info = async () => {
    const urlList = baseUrl+"/info";
    const res = await axios.get(urlList)
                            .then(response => {return response.data})
                            .catch(error=>{return error})
    return res;
}

user.create = async (state) => {

    const datapost = {
        fullname: state.fieldName,
        email: state.fieldEmail,
        password: state.fieldPass1,
        company: state.fieldCompany,
        phone: state.fieldPhone,
        password2: state.fieldPass2
    }

    const urlPost = baseUrl+"/createuser"

    const res = await axios.post(urlPost,datapost)
    	.then(response=>{
    		const data = { success: true, message: response.data }
    		return data;
    	})
    	.catch(error=>{
    		const data = { success: false, message: error.response.data }
    		return data;
    	})

    	return res;
}

user.edit = async (state) => {

    const datapost = {
        fullname: state.fieldName,
        company: state.fieldCompany,
        phone: state.fieldPhone,
        password: state.fieldPass1,
        password2: state.fieldPass2,
        oldpassword: state.fieldOldPass
    }

    const urlPost = baseUrl+"/edituser"

    const res = await axios.post(urlPost,datapost)
    	.then(response=>{
    		const data = { success: true, message: response.data }
    		return data;
    	})
    	.catch(error=>{
    		const data = { success: false, message: error.response.data }
    		return data;
    	})

    	return res;
}

export default user