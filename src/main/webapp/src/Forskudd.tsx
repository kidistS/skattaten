import React, {useState} from 'react'
import trekkprosentFraTabell from "./trekkprosentFraTabell";

export const Forskudd: React.FC = () => {
  // hint useState
   const [bruttoloenn, setBrottloenn] = useState(0);
   const [persontTrekk, setPersontTrekk] = useState(0);
   const handleChange = (e:any) => {
       setBrottloenn(e.target.value)
   }

   const hentTrekkPersont = (x:number) => {
       trekkprosentFraTabell(bruttoloenn)
           .then((response) => {
               console.log(response);
               setPersontTrekk(response);
           }).catch((error) => {
           console.log(error);
       })
   }

  return (
    <div>
      Oppgave 1
        <div>
            <input name={"bruttoloenn"} placeholder={"bruttoloenn"} value={bruttoloenn}
            onChange={(e) => handleChange(e)}/>
        </div>
        <div>
            <input name={"persontTrekk"} placeholder={"persontTrekk"} value={persontTrekk}/>
        </div>
        <button onClick={(e) => hentTrekkPersont(bruttoloenn)}>Hent trekkepersont</button>
    </div>
  )
}

export default Forskudd
