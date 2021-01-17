const baseUrl = "http://localhost:8080/api/user"
import axios from "axios";
const user= {};

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

export default user