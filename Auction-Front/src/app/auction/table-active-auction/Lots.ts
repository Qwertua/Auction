export interface Lots {
  id: number;
  title: string;
  description: string;
  startTime: string;
  endTime: string;
  startingPrice: {
    id: number;
    price: number;
  };
}
