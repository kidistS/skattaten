export const trekkprosentFraTabell = async (bruttoloenn:number) => {
  const url = `http://localhost:8080/forskudd/prosent?bruttoloenn=${bruttoloenn}`
  const response = await fetch(url)
  return parseInt(await response.text())
}

export default trekkprosentFraTabell

