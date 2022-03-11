import { ISO } from "../enum/ISO.enum";

export interface deal{
  id:string;
  file_name:string;
  dealId:string;
  fromCurrency:ISO;
  toCurrency:ISO;
  date:Date;
  amount:number;
  accept:boolean
}
