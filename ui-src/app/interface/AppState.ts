import { ISO } from "../enum/ISO.enum";

export interface AppState<T>{
  dataState:ISO;
  appData?:T;
  error?:string;
}
