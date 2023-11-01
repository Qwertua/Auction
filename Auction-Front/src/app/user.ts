export interface user{
  id: number,
  name: string,
  password: string,
  lots: Lots[];
}

export interface Lots{
  id: any;
  title: string;
  description: string;
  startTime: string;
  endTime: string;
  startingPrice: {
    id: any;
    price: number;
  };
}
